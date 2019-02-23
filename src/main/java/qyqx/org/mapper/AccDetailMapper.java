package qyqx.org.mapper;

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
import qyqx.org.po.AccDetail;
import qyqx.org.po.AccDetailExample;

public interface AccDetailMapper {
    @SelectProvider(type=AccDetailSqlProvider.class, method="countByExample")
    int countByExample(AccDetailExample example);

    @DeleteProvider(type=AccDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(AccDetailExample example);

    @Delete({
        "delete from acc_detail",
        "where acc_detail_id = #{accDetailId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String accDetailId);

    @Insert({
        "insert into acc_detail (acc_detail_id, acc_type_id, ",
        "acc_book_id, user_id, ",
        "trd_amount, trd_date, ",
        "trd_type, remark, ",
        "last_up_time)",
        "values (#{accDetailId,jdbcType=VARCHAR}, #{accTypeId,jdbcType=VARCHAR}, ",
        "#{accBookId,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, ",
        "#{trdAmount,jdbcType=DECIMAL}, #{trdDate,jdbcType=DATE}, ",
        "#{trdType,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{lastUpTime,jdbcType=TIMESTAMP})"
    })
    int insert(AccDetail record);

    @InsertProvider(type=AccDetailSqlProvider.class, method="insertSelective")
    int insertSelective(AccDetail record);

    @SelectProvider(type=AccDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="acc_detail_id", property="accDetailId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="acc_type_id", property="accTypeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="acc_book_id", property="accBookId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="trd_amount", property="trdAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="trd_date", property="trdDate", jdbcType=JdbcType.DATE),
        @Result(column="trd_type", property="trdType", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_up_time", property="lastUpTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AccDetail> selectByExample(AccDetailExample example);

    @Select({
        "select",
        "acc_detail_id, acc_type_id, acc_book_id, user_id, trd_amount, trd_date, trd_type, ",
        "remark, last_up_time",
        "from acc_detail",
        "where acc_detail_id = #{accDetailId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="acc_detail_id", property="accDetailId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="acc_type_id", property="accTypeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="acc_book_id", property="accBookId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="trd_amount", property="trdAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="trd_date", property="trdDate", jdbcType=JdbcType.DATE),
        @Result(column="trd_type", property="trdType", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_up_time", property="lastUpTime", jdbcType=JdbcType.TIMESTAMP)
    })
    AccDetail selectByPrimaryKey(String accDetailId);

    @UpdateProvider(type=AccDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AccDetail record, @Param("example") AccDetailExample example);

    @UpdateProvider(type=AccDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AccDetail record, @Param("example") AccDetailExample example);

    @UpdateProvider(type=AccDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AccDetail record);

    @Update({
        "update acc_detail",
        "set acc_type_id = #{accTypeId,jdbcType=VARCHAR},",
          "acc_book_id = #{accBookId,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=VARCHAR},",
          "trd_amount = #{trdAmount,jdbcType=DECIMAL},",
          "trd_date = #{trdDate,jdbcType=DATE},",
          "trd_type = #{trdType,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "last_up_time = #{lastUpTime,jdbcType=TIMESTAMP}",
        "where acc_detail_id = #{accDetailId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(AccDetail record);
}