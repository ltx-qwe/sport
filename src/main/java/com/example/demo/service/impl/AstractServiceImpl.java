package com.example.demo.service.impl;

import com.example.demo.entity.Astract;
import com.example.demo.entity.User;
import com.example.demo.mapper.AstractMapper;
import com.example.demo.service.IAstractService;

import com.example.demo.service.aex.InsException;
import com.example.demo.service.aex.NotException;
import com.example.demo.service.aex.WordException;
import com.example.demo.service.aex.upException;
import com.example.demo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * 业务层的实现类
 */

@Service
public class AstractServiceImpl implements IAstractService {
    @Autowired
    private AstractMapper astractMapper;


    @Override
    public void re(Astract astract) {

         //通过 astract 参数来获取传递过来的 word 题目
//        String word = astract.getWord();
        String word = astract.getWord();

//        astract.getWord("");
          //调用 findByWord（word）判断t题目是否被添加过
        Astract result = astractMapper.findByWord(word);
        if (result != null) {
         //抛出异常
            throw new WordException("已有该题目");
        }
           // 补全数据：isDelete(0)
//        astract.setIsDelete(0);
       // 补全数据：2 项日志属性
        User user=new User();
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        astract.setCreatedTime(date);
        astract.setModifiedTime(date);

//执行添加业务功能的实现（rows==1）
        Integer rows = astractMapper.sert(astract);
        if (rows != 1) {
            throw new InsException("未知的异常");
        }

    }

    //查询题目
    @Override
    public List < Astract > findAll() {
        //通过 astract 参数来获取传递过来的 id,word....

        return astractMapper.findAll();


    }
 //编辑
        @Override
    public Astract getId(Integer id) {
        // 调用astractMapper的findId(id)方法，根据参数id查询数据
        Astract result = astractMapper.findId(id);

        // 检查查询结果是否为null
        if (result == null) {
// 是：抛出NotException异常
            throw new NotException("数据不存在");

        }
//        // 检查查询结果中的isDelete是否为1
        if (result.getScore().equals(1)) {
// 是：抛出UserNotFoundException异常
            throw new NotException("用户数据不存在");
        }
        // 创建新的User对象
        Astract astract = new Astract();
// 将以上查询结果中的username/phone/email/gender封装到新User对象中
        astract.setWord(result.getWord());
        astract.setAnwser(result.getAnwser());
        astract.setDiff(result.getDiff());
        astract.setNum(result.getNum());
// 返回新的User对象
        return astract;
    }
    @Override
    public void change(Integer id,Astract astract) {
        // 调用astractMapper的findId(id)方法，根据参数id查询数据
        Astract result = astractMapper.findId(id);

        // 检查查询结果是否为null
        if (result == null) {
// 是：抛出NotException异常
            throw new NotException("数据不存在");

        }
        // 检查查询结果中的isDelete是否为1
        if (result.getScore().equals(1)) {
// 是：抛出UserNotFoundException异常
            throw new NotException("数据不存在");
        }

//        // 向参数user中补全数据：uid
//        astract.setId(id);
//// 向参数user中补全数据：modifiedUser(username)
        astract.setModifiedUser("LI");
//// 向参数user中补全数据：modifiedTime(new Date())
        astract.setModifiedTime(new Date());
// 调用userMapper的updateInfoByUid(User user)方法执行修改，并获取返回值
     Integer rows = astractMapper.updateId(astract);
        // 判断以上返回的受影响行数是否不为1
        if (rows == 1) {
// 是：抛出UpdateException异常
            throw new upException("更新用户数据时出现未知错误，请联系系统管理员");
        }


    }

    @Override
    public JsonResult < Void > delete(Integer id) {
        astractMapper.deleteId(id);
        return null;
    }


    //删除

//    @Override
//    public JsonResult < Void > deleteId( Integer id) {
//         astractMapper.deleteId(id);
//        return null;
//    }


}















