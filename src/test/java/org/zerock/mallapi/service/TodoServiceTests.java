package org.zerock.mallapi.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.mallapi.dto.PageRequestDTO;
import org.zerock.mallapi.dto.PageResponseDTO;
import org.zerock.mallapi.dto.TodoDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoServiceTests {

  @Autowired
  private TodoService todoService;

  @Test
  public void testRegister(){
    
    TodoDTO todoDTO = TodoDTO.builder()
    .title("서비스 테스트")
    .writer("tester")
    .dueDate(LocalDate.of(2023, 10,10))
    .build();
    
    Long tno = todoService.register(todoDTO);
    
    log.info("tno: " + tno);
    
  }


  @Test
  public void testGet(){

    Long tno = 401L;

    TodoDTO todoDTO = todoService.get(tno);

    log.info(todoDTO);
  }

  @Test
  public void testModify(){

    TodoDTO todoDTO = TodoDTO.builder()
    .tno(401L)
    .title("서비스 테스트--mod")
    .complete(false)
    .dueDate(LocalDate.of(2023, 10,11))
    .build();
    
    todoService.modify(todoDTO);
    
    log.info(todoDTO);
  }

  @Test
  public void testRemove(){

    Long tno = 402L;

    todoService.remove(tno);

    log.info("tno: "+ tno);
  }


  @Test
  public void testList(){

    PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
      .page(2)
      .size(10)
      .build();

    PageResponseDTO<TodoDTO> response = todoService.list(pageRequestDTO);

    log.info(response);
  }
}
