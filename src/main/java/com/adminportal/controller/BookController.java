package com.adminportal.controller;

import com.adminportal.domain.Book;
import com.adminportal.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * The type Book controller.
 */
@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	/**
	 * Add book string.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBook(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "addBook";
	}

	/**
	 * Add book post string.
	 *
	 * @param book    the book
	 * @param request the request
	 * @return the string
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
		bookService.save(book);

		MultipartFile bookImage = book.getBookImage();

		try {
			byte[] bytes = bookImage.getBytes();
			String name = book.getId() + ".png";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/image/book/" + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:bookList";
	}

	/**
	 * Book info string.
	 *
	 * @param id    the id
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/bookInfo")
	public String bookInfo(@RequestParam("id") Long id, Model model) {
		Book book = bookService.findOne(id);
		model.addAttribute("book", book);

		return "bookInfo";
	}

	/**
	 * Update book string.
	 *
	 * @param id    the id
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/updateBook")
	public String updateBook(@RequestParam("id") Long id, Model model) {
		Book book = bookService.findOne(id);
		model.addAttribute("book", book);

		return "updateBook";
	}

	/**
	 * Update book post string.
	 *
	 * @param book    the book
	 * @param request the request
	 * @return the string
	 */
	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
	public String updateBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
		bookService.save(book);

		MultipartFile bookImage = book.getBookImage();

		if (!bookImage.isEmpty()) {
			try {
				byte[] bytes = bookImage.getBytes();
				String name = book.getId() + ".png";

				Files.delete(Paths.get("src/main/resources/static/image/book/" + name));

				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("src/main/resources/static/image/book/" + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "redirect:/book/bookInfo?id=" + book.getId();
	}

	/**
	 * Book list string.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/bookList")
	public String bookList(Model model) {
		List<Book> bookList = bookService.findAll();
		model.addAttribute("bookList", bookList);
		return "bookList";

	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(Model model, @ModelAttribute("id") String id) {
		bookService.removeOne(Long.parseLong(id.substring(8)));
		List<Book> bookList = bookService.findAll();
		model.addAttribute("bookList", bookList);
		return "redirect:/book/bookList";
	}

}
