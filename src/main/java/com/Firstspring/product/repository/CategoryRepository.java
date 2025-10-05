package com.Firstspring.product.repository;

import com.Firstspring.product.entity.Category;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long > {

Optional<Category> findByName(String categoryName);






}
