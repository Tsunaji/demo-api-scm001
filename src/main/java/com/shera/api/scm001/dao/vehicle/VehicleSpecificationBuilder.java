package com.shera.api.scm001.dao.vehicle;

import com.shera.api.scm001.util.SearchCriteria;
import com.shera.api.scm001.util.SearchOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public class VehicleSpecificationBuilder {

    private final List<SearchCriteria> params;

    public VehicleSpecificationBuilder() {
        params = new ArrayList<>();
    }

    // API
    public final VehicleSpecificationBuilder with(final String key, final String operation, final Object value, final String prefix, final String suffix) {
        return with(null, key, operation, value, prefix, suffix);
    }

    public final VehicleSpecificationBuilder with(final String orPredicate, final String key, final String operation, final Object value, final String prefix, final String suffix) {
        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
        if (op != null) {
            if (op == SearchOperation.EQUALITY) { // the operation may be complex operation
                final boolean startWithAsterisk = prefix != null && prefix.contains(SearchOperation.ZERO_OR_MORE_REGEX);
                final boolean endWithAsterisk = suffix != null && suffix.contains(SearchOperation.ZERO_OR_MORE_REGEX);

                if (startWithAsterisk && endWithAsterisk) {
                    op = SearchOperation.CONTAINS;
                } else if (startWithAsterisk) {
                    op = SearchOperation.ENDS_WITH;
                } else if (endWithAsterisk) {
                    op = SearchOperation.STARTS_WITH;
                }
            }
            params.add(new SearchCriteria(orPredicate, key, op, value));
        }
        return this;
    }

    public Specification<Vehicle> build() {

        if (params.size() == 0) {
            return null;
        }

        Specification<Vehicle> result = new VehicleSpecification(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i)
                    .isOrPredicate()
                            ? Specification.where(result)
                                    .or(new VehicleSpecification(params.get(i)))
                            : Specification.where(result)
                                    .and(new VehicleSpecification(params.get(i)));

        }

        return result;
    }

    public final VehicleSpecificationBuilder with(VehicleSpecification spec) {
        params.add(spec.getCriteria());
        return this;
    }

    public final VehicleSpecificationBuilder with(SearchCriteria criteria) {
        params.add(criteria);
        return this;
    }
}
