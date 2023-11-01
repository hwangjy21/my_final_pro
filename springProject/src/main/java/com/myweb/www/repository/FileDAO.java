package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.BoardDTO;
import com.myweb.www.domain.FileVO;

public interface FileDAO {

	FileVO getDetail_f = null;

	int insertFile(FileVO fvo);

	FileVO getDetail_f(int bno);

	BoardDTO detail(int bno);

	List<FileVO> getDetailFile(long bno);

	int delete_f(String uuid);

	void deleteAll(int bno);

	List<FileVO> selecyListAllFiles();

}
