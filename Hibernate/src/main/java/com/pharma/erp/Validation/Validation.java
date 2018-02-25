/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharma.erp.Validation;

/**
 *
 * @author tarang
 * @param <T>
 */
public interface Validation<T> {
    public boolean isValid(T _data);
    public boolean isInsertable(T _data);
    public boolean isRemovable(T _data);
    public boolean isPresent(T _data);
}
