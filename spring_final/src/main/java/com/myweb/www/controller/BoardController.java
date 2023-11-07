package com.myweb.www.controller;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.myweb.www.domain.BoardDTO;
import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.FileVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.handler.PagingHandler;
import com.myweb.www.handler.FileHandler;
import com.myweb.www.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
public class BoardController {

    @Inject
    private BoardService bsv;
    @Inject
    private FileHandler fh;

    @GetMapping("register")
    public void register() {
        log.info(">>>로그인서비스 들어옴");
    }

    @PostMapping("register")
    public String register(BoardVO bvo, RedirectAttributes re,
            @RequestParam(name = "files", required = false) MultipartFile[] files) {

        log.info(">>>>>bvo>>files>>" + bvo + " /" + files);

        List<FileVO> flist = null;
        if (files != null && files.length > 0 && files[0].getSize() > 0) {
            flist = fh.uploadFiles(files);
            log.info(">>>>>flist" + flist);
        }

        int isUp = bsv.insert(new BoardDTO(bvo, flist));

        return "index";
    }

    @GetMapping("list")
    public void list(Model m, PagingVO pgvo) {
        m.addAttribute("list", bsv.getList(pgvo));
        int totalCount = bsv.getTotalCount(pgvo);
        PagingHandler ph = new PagingHandler(totalCount, pgvo);
        m.addAttribute("ph", ph);
    }

    @GetMapping({ "detail", "modify" })
    public void detail(Model m, @RequestParam("bno") long bno) {
        m.addAttribute("bdto", bsv.getDetil(bno));
    }

    @PostMapping("/modify")
    public String modify(RedirectAttributes re, BoardVO bvo,
            @RequestParam(name="files", required = false) MultipartFile[] files, Principal principal) {
        String username = principal.getName();
        
       
        if (bvo.getWriter().equals(username)) {
            List<FileVO> flist = null;
            if (files != null && files.length > 0 && files[0].getSize() > 0) {
                flist = fh.uploadFiles(files);
            }
            
            int isOk = bsv.modify(new BoardDTO(bvo, flist));
            re.addAttribute("bno", bvo.getBno());
            re.addAttribute("writer", bvo.getWriter());
            re.addFlashAttribute("isMod", isOk);
        } else {
       
        }
        
        return "redirect:/board/detail"; 
    }
    @GetMapping("/remove")
    public String remove(RedirectAttributes re, @RequestParam("bno") long bno, Principal principal) {
        String username = principal.getName();
        
      
        String writer = bsv.getBoardWriter(bno); 
        if (writer != null && writer.equals(username)) {
            int isDel = bsv.remove(bno);
            re.addFlashAttribute("isDel", isDel);
        } else {
            re.addFlashAttribute("isnot_d", "본인만 삭제할 수 있어요!.");
        }
        
        return "redirect:/board/list";
    }

    
    @DeleteMapping(value="/file/{uuid}", produces = MediaType.TEXT_PLAIN_VALUE )
    public ResponseEntity<String> removeFile(@PathVariable("uuid")String uuid){
    return bsv.remveFile(uuid) >0?new ResponseEntity<String>("1", HttpStatus.OK)
			 : new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
    		
}
    
}
