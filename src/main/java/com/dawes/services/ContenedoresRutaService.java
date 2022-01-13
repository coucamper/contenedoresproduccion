package com.dawes.services;

import java.util.List;
import java.util.Optional;


import com.dawes.modelos.ContenedoresRutasVO;

public interface ContenedoresRutaService {

	List<ContenedoresRutasVO> BuscarContenedoresRuta(int idruta);

	<S extends ContenedoresRutasVO> S save(S entity);

	<S extends ContenedoresRutasVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ContenedoresRutasVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ContenedoresRutasVO> findAll();

	Iterable<ContenedoresRutasVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ContenedoresRutasVO entity);

	void deleteAll(Iterable<? extends ContenedoresRutasVO> entities);

	void deleteAll();

}