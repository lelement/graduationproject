package com.example.graduationproject.dao;

import com.example.graduationproject.mapper.CommentMapper;
import com.example.graduationproject.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/1/6
 * @Description:小冯同学写点注释吧！
 */
@Repository
public class CommentDao {
    @Autowired
    CommentMapper commentMapper;
    public Integer addComment(Comment comment) {
        return commentMapper.insert(comment);
    }

    public Integer delCommentById(Integer id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    public List<Comment> selectAll() {
        return commentMapper.selectAll();
    }

    public List<Comment> selComment(Integer bookId) {
        Example example = new Example(Comment.class);
        example.createCriteria().andEqualTo("bookId",bookId);
        return commentMapper.selectByExample(example);
    }
}
