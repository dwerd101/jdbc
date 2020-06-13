package com.learning.dao;

import java.util.List;

public interface CrudDao<T,ID> {
   void save (T model);
   void update (T model, ID id);
   void delete (ID id);
   List<T> findAll(List<T> model);
   T findById(ID id);
}