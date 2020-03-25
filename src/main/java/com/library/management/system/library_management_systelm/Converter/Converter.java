package com.library.management.system.library_management_systelm.Converter;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Converter<M extends Serializable, D> {

    protected static final Logger logger = LoggerFactory.getLogger(Converter.class);

    private ModelMapper modelMapper= new ModelMapper();

    public M convert(D source) {
        return source == null ? null : (M) modelMapper.map(source, getModelClass());
    }

    @Nullable
    public D convert(M source) {
        return source == null ? null : (D) modelMapper.map(source, getDtoClass());
    }

    public List<M> convertAllToEntities(List<D> source) {

        return source == null ? null : source.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public List<D> convertAllToDto(List<M> source) {

        return source == null ? null : source.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public Set<D> convertAllToDto(Set<M> source) {

        return source == null ? null : source.stream()
                .map(this::convert)
                .collect(Collectors.toSet());
    }

    private Class getModelClass() {
        return (Class) getGenerecClass()[0];
    }

    private Class getDtoClass() {
        return (Class) getGenerecClass()[1];
    }

    private Type[] getGenerecClass() {
        return ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments();
    }
}
