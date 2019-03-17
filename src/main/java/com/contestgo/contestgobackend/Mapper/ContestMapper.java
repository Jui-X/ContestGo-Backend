package com.contestgo.contestgobackend.Mapper;

import org.apache.ibatis.annotations.Insert;

public interface ContestMapper {

    @Insert("INSERT INTO contest(name, contest_details, contest_type, apply_deadline, submit_deadline, preliminary_date)")
    void insertContest();
}
