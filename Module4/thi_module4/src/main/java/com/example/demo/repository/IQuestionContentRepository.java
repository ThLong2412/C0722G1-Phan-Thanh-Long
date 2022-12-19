package com.example.demo.repository;

import com.example.demo.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionContentRepository extends JpaRepository<QuestionContent, Long> {
    @Query(value = "select * from question_content as q where  (q.title like concat('%',:title,'%') and q.question_type_id like concat ('%',:questionTypeId,'%') ) order by q.status_id "
            , countQuery = "select * from question_content as q where  (q.title like concat('%',:title,'%') and q.question_type_id like concat ('%',:questionTypeId,'%') ) order by q.status_id"
            , nativeQuery = true)
    Page<QuestionContent> search(Pageable pageable, @Param("title") String title, @Param("questionTypeId") String questionTypeId);
}
