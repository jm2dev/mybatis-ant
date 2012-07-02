package com.jm2dev.localidades;

import org.apache.ibatis.annotations.Select;

public interface ProvinciaMapper {
    @Select("select id, provincia from provincias where id = #{id}")
    Provincia getProvincia(Integer id);
}
