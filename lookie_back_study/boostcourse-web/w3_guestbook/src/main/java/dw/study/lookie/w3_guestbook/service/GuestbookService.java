package dw.study.lookie.w3_guestbook.service;

import java.util.List;

import dw.study.lookie.w3_guestbook.dto.Guestbook;

public interface GuestbookService {
	public static final Integer LIMIT = 5;
	
	public Guestbook addGuestbook(Guestbook gb, String ip);
	public int deleteGuestbook(Long id, String ip);
	public int getCount();
	List<Guestbook> getGuestbooks(Integer start);
}
