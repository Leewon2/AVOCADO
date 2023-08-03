package com.avocado.normal.board.controller;

import com.avocado.Item.domain.entity.Category;
import com.avocado.normal.board.controller.dto.NormalItemDetailResponseDto;
import com.avocado.normal.board.controller.dto.NormalResponseDto;
import com.avocado.normal.board.service.NormalBoardService;
import com.avocado.normal.entity.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/normal")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class NormalBoardController {
    private final NormalBoardService normalBoardService;

    // 예외 던지는데 exception 클래스는 만들지 않겠음
    @GetMapping("/list")
    public ResponseEntity<?> itemList(){
        NormalResponseDto itemlist = normalBoardService.getList();
        log.info("{}",normalBoardService.getList());
        return ResponseEntity.ok().body(itemlist);
    }

    @GetMapping("/list/search/{keyword}")
    public ResponseEntity<?> searchItemList(@PathVariable String keyword){
        NormalResponseDto itemlist = normalBoardService.getSearchList(keyword);
        log.info("{}", normalBoardService.getSearchList(keyword));
        return ResponseEntity.ok().body(itemlist);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> itemDetail(@PathVariable Long id){
        NormalItemDetailResponseDto item = normalBoardService.getItemDetail(id);
        return ResponseEntity.ok().body(item);
    }
    @GetMapping("/list/sort-category")
    public ResponseEntity<?> SortCategoryList(@RequestParam Category category){
        NormalResponseDto itemlist = normalBoardService.getCategoryList(category);
        return ResponseEntity.ok().body(itemlist);
    }
}
