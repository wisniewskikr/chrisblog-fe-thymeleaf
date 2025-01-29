package pl.kwi.chrisblog.controllers.abstr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import pl.kwi.chrisblog.commands.abstr.AbstrPagiantionCommand;

public abstract class AbstrPaginationController extends AbstractController {
	

	protected void handlePagination(AbstrPagiantionCommand command, Page<?> page, int paginationItemsOnPage) {
		
		List<Integer> pages = new ArrayList<Integer>();
		int first = getFirst(command.getCurrentPage(), page.getTotalPages(), paginationItemsOnPage);
		int last = getLast(command.getCurrentPage(), page.getTotalPages(), paginationItemsOnPage);
		for (int i = first; i <= last; i++) {
			pages.add(i);
		}
		command.setPages(pages);
		
		if (command.getCurrentPage() == 1) {
			command.setDisablePrevious(true);
		} else {
			command.setDisablePrevious(false);
		}
		
		if (command.getCurrentPage() == page.getTotalPages() || pages.isEmpty()) {
			command.setDisableNext(true);
		} else {
			command.setDisableNext(false);
		}
		
	}
	
	private int getFirst(int currentPage, int totalPages, int paginationItemsOnPage) {
		
		int result = 1;
		
		if (totalPages <= paginationItemsOnPage) {
			return result;
		}
		
		if ((currentPage - 1 ) > 0) {
			result = currentPage - 1;
		}
		
		if ((currentPage - 2) > 0) {
			result = currentPage - 2;
		}
		
		if ((currentPage - 3) > 0 && (currentPage + 2) > totalPages) {
			result = currentPage - 3;
		}
		
		if ((currentPage - 4) > 0 && (currentPage + 1) > totalPages) {
			result = currentPage - 4;
		}
		
		return result;
		
	}
	
	private int getLast(int currentPage, int totalPages, int paginationItemsOnPage) {
		
		int result = totalPages;
		
		if (totalPages <= paginationItemsOnPage) {
			return result;
		}
		
		if ((currentPage + 1) <= totalPages) {
			result = currentPage + 1;
		}
		
		if ((currentPage + 2) <= totalPages) {
			result = currentPage + 2;
		}
		
		if ((currentPage + 3 ) < totalPages  && (currentPage - 2) <= 0) {
			result = currentPage + 3;
		}
		
		if ((currentPage + 4) < totalPages  && (currentPage - 1) <= 0) {
			result = currentPage + 4;
		}		
		
		return result;
		
	}
	
	
}
