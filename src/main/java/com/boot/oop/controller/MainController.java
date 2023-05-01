package com.boot.oop.controller;

import com.boot.oop.dto.UserDTO;
import com.boot.oop.service.MainService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping
public class MainController {
    private final MainService mainService;
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }
    /**
     * @GetMapping
     * @url localhost/
     * @return <h1>Hello World! By Boot</h1>
     * */
    @GetMapping
    public String getHello() {
        return mainService.getHello();
    }

    /**
     * @Getmapping("parameter)
     * @url <a>localhost/parameter?age=21</a> <br/>
     * @if
     * age < 19: [redirect] <a>https://kwangwoon.sen.hs.kr/</a> <br/>
     * @else
     * age > 19: [redirect] <a>localhost:3000</a>
     * @param response
     * HttpServletResponse를 사용해서 redirect 처리를 함.<br/>
     * View의 반환이 없는 @RestController의 경우, return "redirect:"가 안됨
     * */
    @GetMapping("parameter")
    public void parameterURL(@RequestParam int age, HttpServletResponse response) throws Exception {
        log.info("/parameter?age=${age} APPROACH");
        if (age < 19) {
             response.sendRedirect("https://kwangwoon.sen.hs.kr/");
        } else {
            response.sendRedirect("http://localhost:3000/");
        }
    }

    /**
     * @GetMapping("/{param}")
     * @param param @PathVariable > 해당 url 뒤에 있는 값을 받겠다.
     * @type Object > Java 최상위 타입. 즉, 모든 종류의 타입 OK
     * @return "<h1>" + param + " REQUEST by BOOT" + "</h1>"
     * */
    @GetMapping("/{param}")
    public String parameterURL(@PathVariable Object param) {
        return this.mainService.printParam(param);
    }
    /**
     * @PostMapping()
     * @param dto @RequestBody JSON TYPE
     * @return Void -> ResponseEntity.ok().build -> Client:get200
     * */
    @PostMapping()
    public ResponseEntity<Void> jsonBodyParameter(@RequestBody UserDTO dto) {
        log.info("Json Object: " + dto);
        return ResponseEntity.ok().build();
    }
}
