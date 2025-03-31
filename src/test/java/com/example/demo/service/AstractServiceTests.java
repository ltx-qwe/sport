package com.example.demo.service;


import com.example.demo.entity.Astract;
import com.example.demo.service.aex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AstractServiceTests {
    @Autowired
    private IAstractService iAstractService;
    @Test
    public void re(){
        try {
            Astract astract = new Astract();

            astract.setId(2946);
            astract.setWord("数据模型是由     ①     、     ②     和     ③     三部分组成的。");
            astract.setAnwser(" ①数据结构    ②数据操作    ③完整性约束");
            astract.setDiff("中");
            astract.setNum(3);
            iAstractService.re(astract);
            System.out.println("ok");
        }catch (ServiceException e){
//获取类的对象，再获取类的名称
            System.out.println("添加失败！"+e.getClass().getSimpleName());
//获取类的具体描述信息
            System.out.println(e.getMessage());
        }
    }



    @Test
    public void getId() {
        try {
            Integer id = 3;
            Astract astract= iAstractService.getId(id);

            System.out.println(astract);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void change() {
        try {
            Integer id = 3;
//           String LI = "数据管理员";
            Astract astract = new Astract();
            astract.setWord("nh");
            astract.setAnwser("h");
            astract.setDiff("h");
           astract.setNum(2);
//            iAstractService.change(id,astract);
            iAstractService.change(id,astract);
            System.out.println("ok");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void delete() {
        try {
            Integer id = 21;
//
            iAstractService.delete(21);
            System.out.println("ok");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }


    }
}
