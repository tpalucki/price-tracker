/*
 * This file is generated by jOOQ.
 */
package io.github.tpalucki.pricetracker.tables;


import io.github.tpalucki.pricetracker.Keys;
import io.github.tpalucki.pricetracker.Public;
import io.github.tpalucki.pricetracker.tables.records.ProductsRecord;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.UUID;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Name;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Products extends TableImpl<ProductsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.products</code>
     */
    public static final Products PRODUCTS = new Products();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProductsRecord> getRecordType() {
        return ProductsRecord.class;
    }

    /**
     * The column <code>public.products.id</code>.
     */
    public final TableField<ProductsRecord, UUID> ID = createField(DSL.name("id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.products.title</code>.
     */
    public final TableField<ProductsRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.products.link</code>.
     */
    public final TableField<ProductsRecord, String> LINK = createField(DSL.name("link"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.products.small_img_url</code>.
     */
    public final TableField<ProductsRecord, String> SMALL_IMG_URL = createField(DSL.name("small_img_url"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.products.medium_img_url</code>.
     */
    public final TableField<ProductsRecord, String> MEDIUM_IMG_URL = createField(DSL.name("medium_img_url"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.products.big_img_url</code>.
     */
    public final TableField<ProductsRecord, String> BIG_IMG_URL = createField(DSL.name("big_img_url"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.products.oryginal_img_url</code>.
     */
    public final TableField<ProductsRecord, String> ORYGINAL_IMG_URL = createField(DSL.name("oryginal_img_url"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>public.products.description_text</code>.
     */
    public final TableField<ProductsRecord, String> DESCRIPTION_TEXT = createField(DSL.name("description_text"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.products.year</code>.
     */
    public final TableField<ProductsRecord, Integer> YEAR = createField(DSL.name("year"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.products.elements</code>.
     */
    public final TableField<ProductsRecord, Integer> ELEMENTS = createField(DSL.name("elements"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.products.price_per_element</code>.
     */
    public final TableField<ProductsRecord, BigDecimal> PRICE_PER_ELEMENT = createField(DSL.name("price_per_element"), SQLDataType.NUMERIC(10, 2), this, "");

    /**
     * The column <code>public.products.currency</code>.
     */
    public final TableField<ProductsRecord, String> CURRENCY = createField(DSL.name("currency"), SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.products.current_minimal_price</code>.
     */
    public final TableField<ProductsRecord, BigDecimal> CURRENT_MINIMAL_PRICE = createField(DSL.name("current_minimal_price"), SQLDataType.NUMERIC(10, 2), this, "");

    private Products(Name alias, Table<ProductsRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Products(Name alias, Table<ProductsRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>public.products</code> table reference
     */
    public Products(String alias) {
        this(DSL.name(alias), PRODUCTS);
    }

    /**
     * Create an aliased <code>public.products</code> table reference
     */
    public Products(Name alias) {
        this(alias, PRODUCTS);
    }

    /**
     * Create a <code>public.products</code> table reference
     */
    public Products() {
        this(DSL.name("products"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<ProductsRecord> getPrimaryKey() {
        return Keys.PRODUCTS_PKEY;
    }

    @Override
    public Products as(String alias) {
        return new Products(DSL.name(alias), this);
    }

    @Override
    public Products as(Name alias) {
        return new Products(alias, this);
    }

    @Override
    public Products as(Table<?> alias) {
        return new Products(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Products rename(String name) {
        return new Products(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Products rename(Name name) {
        return new Products(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Products rename(Table<?> name) {
        return new Products(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Products where(Condition condition) {
        return new Products(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Products where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Products where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Products where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Products where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Products where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Products where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Products where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Products whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Products whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
