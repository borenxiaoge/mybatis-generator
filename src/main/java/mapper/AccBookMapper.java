package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import po.AccBook;
import po.AccBookExample;

public interface AccBookMapper {
    @SelectProvider(type=AccBookSqlProvider.class, method="countByExample")
    int countByExample(AccBookExample example);

    @DeleteProvider(type=AccBookSqlProvider.class, method="deleteByExample")
    int deleteByExample(AccBookExample example);

    @Delete({
        "delete from acc_book",
        "where acc_book_id = #{accBookId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String accBookId);

    @Insert({
        "insert into acc_book (acc_book_id, acc_book_name, ",
        "open_id, user_id, ",
        "last_up_time)",
        "values (#{accBookId,jdbcType=VARCHAR}, #{accBookName,jdbcType=VARCHAR}, ",
        "#{openId,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, ",
        "#{lastUpTime,jdbcType=TIMESTAMP})"
    })
    int insert(AccBook record);

    @InsertProvider(type=AccBookSqlProvider.class, method="insertSelective")
    int insertSelective(AccBook record);

    @SelectProvider(type=AccBookSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="acc_book_id", property="accBookId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="acc_book_name", property="accBookName", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_up_time", property="lastUpTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AccBook> selectByExample(AccBookExample example);

    @Select({
        "select",
        "acc_book_id, acc_book_name, open_id, user_id, last_up_time",
        "from acc_book",
        "where acc_book_id = #{accBookId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="acc_book_id", property="accBookId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="acc_book_name", property="accBookName", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_up_time", property="lastUpTime", jdbcType=JdbcType.TIMESTAMP)
    })
    AccBook selectByPrimaryKey(String accBookId);

    @UpdateProvider(type=AccBookSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AccBook record, @Param("example") AccBookExample example);

    @UpdateProvider(type=AccBookSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AccBook record, @Param("example") AccBookExample example);

    @UpdateProvider(type=AccBookSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AccBook record);

    @Update({
        "update acc_book",
        "set acc_book_name = #{accBookName,jdbcType=VARCHAR},",
          "open_id = #{openId,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=VARCHAR},",
          "last_up_time = #{lastUpTime,jdbcType=TIMESTAMP}",
        "where acc_book_id = #{accBookId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(AccBook record);
}