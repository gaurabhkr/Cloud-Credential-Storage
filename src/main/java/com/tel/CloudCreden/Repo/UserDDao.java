package com.tel.CloudCreden.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tel.CloudCreden.Models.UserD;

@Repository
public interface UserDDao extends JpaRepository<UserD, Integer>{
	
	
	//we are using a query annot to navigate table as username
	//we will change the table name in query not in UserD
	
	@Query(value="SELECT * FROM public.usercred ORDER BY link ASC ; ",nativeQuery = true)
	public List<UserD> getall();
	
	
	@Query(value="SELECT * FROM public.usercred a "
			+ " where LOWER(a.category) LIKE LOWER(CONCAT('%',CAST(?1 AS text),'%'))",nativeQuery =true)
	public List<UserD> findByCategory(String category);

	
	@Query(value="SELECT * FROM public.usercred a "
			+ " where LOWER(a.category) LIKE LOWER(CONCAT('%',CAST(?1 AS text),'%'))",nativeQuery =true)
	public List<UserD> findByLink(String Link);

 //Prim key make problem can be used to make dat   CAST(?1 AS TEXT)
	
	@Query(value="insert into public.usercred "
			+ "values(:#{#u.getlink},:#{#u.getAbout},:#{#u.getWebUsername},:#{#u.getWebPassword},:#{#u.getCategory},:#{#u.getId});"
			,nativeQuery =true)
	public void insertentry(@Param("u") UserD u);
	
	@Query(value="update public.usercred set username=CAST(?1 AS text) where link=CAST(?3 AS text) AND username=CAST(?2 AS text) ;",nativeQuery =true)
	public void updatebyusername(String newwebusername,String previoususername,String link);
	
	@Query(value="update public.usercred set password=CAST(?1 AS text) where link=CAST(?3 AS text) AND username=CAST(?2 AS text) ;",nativeQuery =true)
	public void updatebypassword(String newwebpassword,String username,String link);
	
	@Query(value="update public.usercred set about=CAST(?1 AS text) where link=CAST(?2 AS text) ;",nativeQuery =true)
	public void updatebyabout(String about,String link);
	
	@Query(value="update public.usercred set link=CAST(?1 AS text) where link=CAST(?2 AS text) ;",nativeQuery =true)
	public void updatebylink(String newlink,String previouslink);
	
//	@Query(value="",nativeQuery =true)
//	public void deleteentry(String link);
	
	//Used to change table name
//	@Query(value="ALTER TABLE IF EXISTS public.{}   \r\n"
//			+ "    RENAME TO ?2;",nativeQuery =true)
//	public void changeusername(String prevusername,String newusername);
	
}
