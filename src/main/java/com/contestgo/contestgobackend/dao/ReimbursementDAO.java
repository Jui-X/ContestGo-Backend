package com.contestgo.contestgobackend.dao;

import com.contestgo.contestgobackend.vo.ReimbursementRecordVO;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.util.List;

public interface ReimbursementDAO {

    @Select("SELECT reimbursement_item, reimbursement_amount, reimbursement_type, reimbursement_attachment FROM reimbursement " +
            "WHERE team_in_contest_id = #{team_in_contest_id}")
    @Results({@Result(column = "reimbursement_item", property = "reimbursementItem"),
              @Result(column = "reimbursement_amount", property = "reimbursementAmount"),
              @Result(column = "reimbursement_type", property = "reimbursementType"),
              @Result(column = "reimbursement_attachment", property = "reimbursementAttachment")
    })
    List<ReimbursementRecordVO> getMyReimbursementRecord(@Param("team_in_contest_id")int teamInContestId);

    @Insert("INSERT INTO reimbursement(team_in_contest_id, reimbursement_item, reimbursement_amount, reimbursement_type, " +
            "reimbursement_attachment) VALUES(#{team_in_contest_id}, #{reimbursement_item}, #{reimbursement_amount}, " +
            "#{reimbursement_type}, #{reimbursement_attachment})")
    void addReimbursementRecord(@Param("team_in_contest_id")int teamInContestId, @Param("reimbursement_item")String reimbursementItem,
                                @Param("reimbursement_amount") BigDecimal reimbursementAmount, @Param("reimbursement_type")int reimbursementType,
                                @Param("reimbursement_attachment")String reimbursementAttachment);
}
