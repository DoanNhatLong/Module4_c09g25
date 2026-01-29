package com.example.ss7_spring_data.repository;

import com.example.ss7_spring_data.entity.Blog;
import com.example.ss7_spring_data.dto.ViewDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
    List<ViewDto> findAllView();
}
