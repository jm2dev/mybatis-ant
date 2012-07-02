package com.jm2dev.localidades;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;

public interface ProvinciaMapper {
    @Select("select id, provincia, comunidad_id from provincias where id = #{id}")
    @Results(value = {
            @Result(property="id"),
            @Result(property="nombre", column="provincia"),
            @Result(property="comunidadId", column="comunidad_id")
    })
    Provincia getProvincia(Integer id);
}
