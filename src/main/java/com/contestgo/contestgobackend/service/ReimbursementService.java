package com.contestgo.contestgobackend.service;

import com.contestgo.contestgobackend.vo.ReimbursementContestVO;
import com.contestgo.contestgobackend.vo.ReimbursementRecordVO;

import java.math.BigDecimal;
import java.util.List;

public interface ReimbursementService {
    List<ReimbursementContestVO> listMyReimbursementContest(String stuId);

    List<ReimbursementRecordVO> getMyReimbursementRecord(int teamInContestId);

    void addReimbursementRecord(int teamInContestId, String reimbursementItem, BigDecimal reimbursementAmount,
                                int reimbursementType, String reimbursementAttachment);
}
