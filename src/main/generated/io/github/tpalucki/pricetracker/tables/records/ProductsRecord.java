/*
 * This file is generated by jOOQ.
 */
package io.github.tpalucki.pricetracker.tables.records;


import io.github.tpalucki.pricetracker.tables.Products;

import java.math.BigDecimal;
import java.util.UUID;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class ProductsRecord extends UpdatableRecordImpl<ProductsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.products.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.products.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.products.title</code>.
     */
    public void setTitle(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.products.title</code>.
     */
    public String getTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.products.link</code>.
     */
    public void setLink(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.products.link</code>.
     */
    public String getLink() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.products.small_img_url</code>.
     */
    public void setSmallImgUrl(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.products.small_img_url</code>.
     */
    public String getSmallImgUrl() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.products.medium_img_url</code>.
     */
    public void setMediumImgUrl(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.products.medium_img_url</code>.
     */
    public String getMediumImgUrl() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.products.big_img_url</code>.
     */
    public void setBigImgUrl(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.products.big_img_url</code>.
     */
    public String getBigImgUrl() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.products.oryginal_img_url</code>.
     */
    public void setOryginalImgUrl(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.products.oryginal_img_url</code>.
     */
    public String getOryginalImgUrl() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.products.description_text</code>.
     */
    public void setDescriptionText(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.products.description_text</code>.
     */
    public String getDescriptionText() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.products.year</code>.
     */
    public void setYear(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.products.year</code>.
     */
    public Integer getYear() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>public.products.elements</code>.
     */
    public void setElements(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.products.elements</code>.
     */
    public Integer getElements() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>public.products.price_per_element</code>.
     */
    public void setPricePerElement(BigDecimal value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.products.price_per_element</code>.
     */
    public BigDecimal getPricePerElement() {
        return (BigDecimal) get(10);
    }

    /**
     * Setter for <code>public.products.currency</code>.
     */
    public void setCurrency(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.products.currency</code>.
     */
    public String getCurrency() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.products.current_minimal_price</code>.
     */
    public void setCurrentMinimalPrice(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.products.current_minimal_price</code>.
     */
    public String getCurrentMinimalPrice() {
        return (String) get(12);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ProductsRecord
     */
    public ProductsRecord() {
        super(Products.PRODUCTS);
    }

    /**
     * Create a detached, initialised ProductsRecord
     */
    public ProductsRecord(UUID id, String title, String link, String smallImgUrl, String mediumImgUrl, String bigImgUrl, String oryginalImgUrl, String descriptionText, Integer year, Integer elements, BigDecimal pricePerElement, String currency, String currentMinimalPrice) {
        super(Products.PRODUCTS);

        setId(id);
        setTitle(title);
        setLink(link);
        setSmallImgUrl(smallImgUrl);
        setMediumImgUrl(mediumImgUrl);
        setBigImgUrl(bigImgUrl);
        setOryginalImgUrl(oryginalImgUrl);
        setDescriptionText(descriptionText);
        setYear(year);
        setElements(elements);
        setPricePerElement(pricePerElement);
        setCurrency(currency);
        setCurrentMinimalPrice(currentMinimalPrice);
        resetChangedOnNotNull();
    }
}