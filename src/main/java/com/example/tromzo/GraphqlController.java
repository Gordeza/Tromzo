package com.example.tromzo;


import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class GraphqlController {
    private final ObjectManager objectManager;

    /**
     * Retrieves an object from the object manager.
     * @return The retrieved object.
     */
    @QueryMapping
    public Integer getObject() {
        return objectManager.get_object();
    }

    /**
     * Handles a mutation request to free an object.
     * @param obj The object to be freed.
     * @return true if the object was successfully freed and added back to the collection,
     * false if the object was not found in the used objects collection.
     */
    @MutationMapping
    public Boolean freeObject(@Argument Integer obj) {
        return objectManager.free_object(obj);
    }
}
