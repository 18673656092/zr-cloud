package com.zr.cloud.cloudserver.DAO;

import com.zr.cloud.cloudserver.DO.BookDO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhuran on 2018/8/6 0006
 */
@Repository
@Mapper
public interface BookDAO {

    @Insert("INSERT INTO `cloud`.`book` (`title`, `author`, `address`, `creation_time`, `update_time`,`number`,`NO`) VALUES (#{title}, #{author}, #{address}, #{creationTime}, #{updateTime},#{number},#{no})")
    boolean addBook(BookDO bookDO);
    @Update("UPDATE `cloud`.`book` SET `title`=#{title}, `author`=#{author}, `address`=#{address}, `creation_time`=#{creationTime}, `update_time`=#{updateTime}, `number`=#{number} WHERE (`NO`=#{no});")
    boolean updateBook(BookDO bookDO);
    @Update("UPDATE `cloud`.`book` SET `number`=#{number} WHERE `title`=#{title}, `author`=#{author}, `address`=#{address};")
    boolean updateBookNumber(BookDO bookDO);
    @Select("SELECT * FROM `cloud`.`book`")
    List<BookDO> selectBookTotal();
    @Select("SELECT * FROM `cloud`.`book` WHERE `NO`=#{no}")
    BookDO selectBook(String NO);
    @Delete("DELETE FROM `cloud`.`book` WHERE `NO`=#{no}")
    boolean delBook(String NO);
}
