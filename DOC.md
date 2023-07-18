# API Definitions and Data Structures

## GraphQL Endpoint

### Endpoint: `/graphql`
- Description: Accepts GraphQL queries and mutations to interact with the application's data.
- Supported Operations:
    - Query: `getObject`
        - Description: Retrieves an object from the object manager.
        - Returns: The retrieved object, if no objects are available returns null.
        - `query {
          getObject
          }`
    - Mutation: `freeObject`
        - Description: Handles a mutation request to free an object.
        - Parameters:
            - `obj` (Integer): The object to be freed.
        - Returns: true if the object was successfully freed and added back to the collection, false if the object was not found to be freed.
        - `mutation {
          freeObject(obj: n)
          }`


### Data Structures Description

The application uses a GraphQL-based approach to handle requests. The GraphQL endpoint `/graphql` accepts various operations to interact with the data.

- The `ObjectManager` class manages a pool of objects:
  - The pool of objects is implemented as two sets (where the objects are distributed): `freeObjects` (contains objects that can be used) and `usedObjects` (contains used objects that need to be freed).
  - `get_object()`: Retrieves an object from the `freeObjects` and removes from `freeObjects` and adds to `usedObjects`.  If there are no free objects available, it returns `null`.
  - `free_object(int obj)`: Frees the specified object, removes from `usedObjects` and adds it back to the `freeObjects`. If the object is not found in the `usedObjects`, it returns `false`.

