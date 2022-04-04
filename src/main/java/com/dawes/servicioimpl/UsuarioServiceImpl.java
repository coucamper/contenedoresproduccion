package com.dawes.servicioimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dawes.modelos.UsuarioVO;
import com.dawes.repository.UsuarioRepo;
import com.dawes.services.InterfaceUsuarioService;
import com.dawes.services.UsuarioService;

@Primary
@Service
public class UsuarioServiceImpl implements UsuarioRepo, UsuarioService, UserDetailsService, InterfaceUsuarioService {

	@Autowired
	UsuarioRepo ur;

	public UsuarioVO findByUsername(String username) {
		return ur.findByUsername(username);
	}

	public <S extends UsuarioVO> S save(S entity) {
		return ur.save(entity);
	}

	public <S extends UsuarioVO> Optional<S> findOne(Example<S> example) {
		return ur.findOne(example);
	}

	public Page<UsuarioVO> findAll(Pageable pageable) {
		return ur.findAll(pageable);
	}

	public List<UsuarioVO> findAll() {
		return ur.findAll();
	}

	public List<UsuarioVO> findAll(Sort sort) {
		return ur.findAll(sort);
	}

	public List<UsuarioVO> findAllById(Iterable<Integer> ids) {
		return ur.findAllById(ids);
	}

	public <S extends UsuarioVO> List<S> saveAll(Iterable<S> entities) {
		return ur.saveAll(entities);
	}

	public Optional<UsuarioVO> findById(Integer id) {
		return ur.findById(id);
	}

	public void flush() {
		ur.flush();
	}

	public <S extends UsuarioVO> S saveAndFlush(S entity) {
		return ur.saveAndFlush(entity);
	}

	public boolean existsById(Integer id) {
		return ur.existsById(id);
	}

	public void deleteInBatch(Iterable<UsuarioVO> entities) {
		ur.deleteInBatch(entities);
	}

	public <S extends UsuarioVO> Page<S> findAll(Example<S> example, Pageable pageable) {
		return ur.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		ur.deleteAllInBatch();
	}

	public UsuarioVO getOne(Integer id) {
		return ur.getOne(id);
	}

	public <S extends UsuarioVO> long count(Example<S> example) {
		return ur.count(example);
	}

	public <S extends UsuarioVO> boolean exists(Example<S> example) {
		return ur.exists(example);
	}

	public <S extends UsuarioVO> List<S> findAll(Example<S> example) {
		return ur.findAll(example);
	}

	public long count() {
		return ur.count();
	}

	public void deleteById(Integer id) {
		ur.deleteById(id);
	}

	public <S extends UsuarioVO> List<S> findAll(Example<S> example, Sort sort) {
		return ur.findAll(example, sort);
	}

	public void delete(UsuarioVO entity) {
		ur.delete(entity);
	}

	public void deleteAll(Iterable<? extends UsuarioVO> entities) {
		ur.deleteAll(entities);
	}

	public void deleteAll() {
		ur.deleteAll();
	}
	
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UsuarioVO usuario = ur.findByUsername(username);
		
		if( usuario == null ) {
			logger.error("Error de Login: No existe el usuario '"+username+"' en el sistema");
			throw new UsernameNotFoundException("Error de Login: No existe el usuario '"+username+"' en el sistema");
		}

		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getRole()))
				.peek(authority -> logger.info("Role: "+authority.getAuthority()))
				.collect(Collectors.toList());	
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}
	
	
}
