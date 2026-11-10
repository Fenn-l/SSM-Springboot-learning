package com.ape.springboot_mybatis.dao;

import com.ape.springboot_mybatis.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpDao {
	@Insert("insert into emp(ename,egender,esalary) values(#{ename},#{egender},#{esalary})")
	public int saveEmp(Emp emp);

	@Insert("insert into emp(ename,egender,esalary) values(#{ename},#{egender},#{esalary})")
	@Options(useGeneratedKeys = true, keyProperty = "eid")
	public int saveEmpBackOne(Emp emp);

	@Update("update emp set ename=#{ename},egender=#{egender},esalary=#{esalary} where eid=#{eid}")
	public int updateEmp(Emp newEmp);

	@Delete("delete from emp where eid = #{delId}")
	public int deleteById(@Param("delId") int delId);

	@Select("select * from emp")
	public List<Emp> findAll();


	@Select("select * from emp where eid = #{id}")
	public Emp findById(@Param("id") int id);

	@Select("select * from emp where ename = #{a}")
	public Emp findByName(@Param("a") String name);

	@Select("select * from emp where ename = #{names} and egender = #{genders}")
	public List<Emp> findByNameAndGender(@Param("names") String name, @Param("genders") String gender);


	//@Results等价于resutMap
	@Select("select * from emp")
	@Results(id="maps",value = {
			@Result(id=true,column="eid",property="eid"),
			@Result(id=false,column="ename",property="ename"),
			@Result(id=false,column="egender",property="egender"),
			@Result(id=false,column="esalary",property="esalary")
	})
	public List<Emp> findResultOne();




	@ResultMap("maps")//进行复用
	@Select("select * from emp")
	public List<Emp> findResultTwo();


	@ResultMap("maps")//进行复用
	@SelectProvider(type= EmpSql.class,method = "findSql")
	public List<Emp> findSql(Emp emp);
}
