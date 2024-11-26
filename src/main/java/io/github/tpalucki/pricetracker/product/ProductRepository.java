package io.github.tpalucki.pricetracker.product;

import io.github.tpalucki.pricetracker.Tables;
import io.github.tpalucki.pricetracker.tables.records.ProductsRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    private final DSLContext context;

    public ProductRepository(DSLContext context) {
        this.context = context;
    }

    public void insert(Product product) {
        context.insertInto(Tables.PRODUCTS)
                .set(toRecord(product, context.newRecord(Tables.PRODUCTS)))
                .execute();
    }

    private ProductsRecord toRecord(Product product, ProductsRecord baseRecord) {
        baseRecord.setId(product.id());
        baseRecord.setTitle(product.title());
        baseRecord.setLink(product.link());
        baseRecord.setSmallImgUrl(product.smallImg());
        baseRecord.setMediumImgUrl(product.mediumImg());
        baseRecord.setBigImgUrl(product.bigImg());
        baseRecord.setOryginalImgUrl(product.oryginalImg());
//        baseRecord.setDescriptionText(product.description());
//        baseRecord.setYear(product.year());
//        baseRecord.setElements(product.elements());
//        baseRecord.setPricePerElement(product.pricePerElement());
//        baseRecord.setCurrency(product.currency().toString());
//        baseRecord.setCurrentMinimalPrice(product.currentMinimalPrice());
        return baseRecord;
    }
}
