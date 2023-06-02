package com.ensah.absence.repositories;

import com.ensah.absence.entities.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ElementsRepository extends JpaRepository<Element,Long> {
    List<Element> findAllByModuleIdModule(Long id);
    Element findElementByIdElement(Long id);
    List<Element> findAll();

}
