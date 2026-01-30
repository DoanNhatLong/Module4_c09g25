package com.example.ss7_spring_data.repository;

import com.example.ss7_spring_data.entity.Blog;
import com.example.ss7_spring_data.dto.ViewDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iBlogRepository extends JpaRepository<Blog, Integer> {
    @Query("""
                select new com.example.ss7_spring_data.dto.ViewDto(
                    b.id,
                    b.title,
                    b.content,
                    c.name
                )
                from Blog b
                join b.category c
            """)
    Page<ViewDto> findAllView(Pageable pageable);

    @Query("""
                select new com.example.ss7_spring_data.dto.ViewDto(
                    b.id,
                    b.title,
                    b.content,
                    c.name
                )
                from Blog b
                join b.category c
                where
                    (:title is null or b.title like concat('%', :title, '%'))
                and (:content is null or b.content like concat('%', :content, '%'))
                and (:categoryId is null or c.id = :categoryId)
                order by b.id desc
            """)
    Page<ViewDto> search(
            @Param("title") String title,
            @Param("content") String content,
            @Param("categoryId") Integer categoryId,
            Pageable pageable
    );
}
