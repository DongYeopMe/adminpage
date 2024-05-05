package adminpage.project.product.repository;

import adminpage.project.product.dto.ProductListRequest;
import adminpage.project.product.dto.ProductListResponse;
import adminpage.project.product.dto.ProductResponse;
import adminpage.project.product.entity.Category;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

import static adminpage.project.product.entity.QProduct.product;

@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryCustom{
    private final JPAQueryFactory queryFactory;
    @Override
    public List<ProductListResponse> findByProductsByCodeOrNameOrCategory(ProductListRequest productListRequest) {
        return queryFactory.select(Projections.fields(
                        ProductListResponse.class,
        product.id,
        product.name,
        product.code,
        product.category,
        product.price,
        product.open
        ))
                .from(product)
                .where(condNameLike(productListRequest.getName()),condCodeLike(productListRequest.getCode()),condCategory(productListRequest.getCategory()))
                .orderBy(product.id.desc())
                .fetch();
    }
    private static Predicate condNameLike(String name) {
        return StringUtils.hasText(name) ? product.name.contains(name) : null;
    }
    private static Predicate condCodeLike(String code){
        return StringUtils.hasText(code) ? product.code.contains(code) : null;
    }

    private static Predicate condCategory(Category category) {
        return category != null ? product.category.eq(category) : null;
    }
}
