package com.shulgin.yandex.yandex;

public class JsonStrings {
    public final static String[] CORRECT_IMPORT_STRINGS = {
        "{\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"type\": \"CATEGORY\",\n" +
                "                \"name\": \"Товары\",\n" +
                "                \"id\": \"069cb8d7-bbdd-47d3-ad8f-82ef4c269df1\",\n" +
                "                \"parentId\": null\n" +
                "            }\n" +
                "        ],\n" +
                "        \"updateDate\": \"2022-02-01T12:00:00.000Z\"\n" +
                "    " +
                "}",
        "{\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"type\": \"OFFER\",\n" +
                "                \"name\": \"jPhone 13\",\n" +
                "                \"id\": \"863e1a7a-1304-42ae-943b-179184c077e3\",\n" +
                "                \"parentId\": \"d515e43f-f3f6-4471-bb77-6b455017a2d2\",\n" +
                "                \"price\": 79999\n" +
                "            },\n" +
                "            {\n" +
                "                \"type\": \"OFFER\",\n" +
                "                \"name\": \"Xomiа Readme 10\",\n" +
                "                \"id\": \"b1d8fd7d-2ae3-47d5-b2f9-0f094af800d4\",\n" +
                "                \"parentId\": \"d515e43f-f3f6-4471-bb77-6b455017a2d2\",\n" +
                "                \"price\": 59999\n" +
                "            },\n" +
                "            {\n" +
                "                \"type\": \"CATEGORY\",\n" +
                "                \"name\": \"Смартфоны\",\n" +
                "                \"id\": \"d515e43f-f3f6-4471-bb77-6b455017a2d2\",\n" +
                "                \"parentId\": \"069cb8d7-bbdd-47d3-ad8f-82ef4c269df1\"\n" +
                "            }\n" +
                "\n" +
                "        ],\n" +
                "        \"updateDate\": \"2022-02-02T12:00:00.000Z\"\n" +
                "    " +
                "}",
        "{\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"type\": \"OFFER\",\n" +
                "                \"name\": \"Samson 70\\\" LED UHD Smart\",\n" +
                "                \"id\": \"98883e8f-0507-482f-bce2-2fb306cf6483\",\n" +
                "                \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
                "                \"price\": 32999\n" +
                "            },\n" +
                "            {\n" +
                "                \"type\": \"OFFER\",\n" +
                "                \"name\": \"Phyllis 50\\\" LED UHD Smarter\",\n" +
                "                \"id\": \"74b81fda-9cdc-4b63-8927-c978afed5cf4\",\n" +
                "                \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
                "                \"price\": 49999\n" +
                "            },\n" +
                "            {\n" +
                "                \"type\": \"CATEGORY\",\n" +
                "                \"name\": \"Телевизоры\",\n" +
                "                \"id\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
                "                \"parentId\": \"069cb8d7-bbdd-47d3-ad8f-82ef4c269df1\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"updateDate\": \"2022-02-03T12:00:00.000Z\"\n" +
                "    " +
                "}",
        "{\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"type\": \"OFFER\",\n" +
                "                \"name\": \"Goldstar 65\\\" LED UHD LOL Very Smart\",\n" +
                "                \"id\": \"73bc3b36-02d1-4245-ab35-3106c9ee1c65\",\n" +
                "                \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
                "                \"price\": 69999\n" +
                "            }\n" +
                "        ],\n" +
                "        \"updateDate\": \"2022-02-03T15:00:00.000Z\"\n" +
                "    " +
                "}"
    };

    public final static String[] INCORRECT_IMPORT_STRINGS = {
            //Одинаковые id
            "{\n" +
                    "        \"items\": [\n" +
                    "            {\n" +
                    "                \"type\": \"OFFER\",\n" +
                    "                \"name\": \"jPhone 14\",\n" +
                    "                \"id\": \"863e1a7a-1304-42ae-943b-179184c077e311\",\n" +
                    "                \"parentId\": \"d515e43f-f3f6-4471-bb77-6b455017a2d2\",\n" +
                    "                \"price\": 79999\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"type\": \"OFFER\",\n" +
                    "                \"name\": \"Xomiа Readme 12\",\n" +
                    "                \"id\": \"863e1a7a-1304-42ae-943b-179184c077e311\",\n" +
                    "                \"parentId\": \"d515e43f-f3f6-4471-bb77-6b455017a2d2\",\n" +
                    "                \"price\": 59999\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"updateDate\": \"2022-02-02T18:01:00.000Z\"\n" +
                    "    " +
                    "}",
            // Родителем товара является товар
            "{\n" +
                    "        \"items\": [\n" +
                    "            {\n" +
                    "                \"type\": \"OFFER\",\n" +
                    "                \"name\": \"jPhone 14\",\n" +
                    "                \"id\": \"863e1a7a-1304-42ae-943b-179184c077e311\",\n" +
                    "                \"parentId\": \"d515e43f-f3f6-4471-bb77-6b455017a2d2\",\n" +
                    "                \"price\": 79999\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"type\": \"OFFER\",\n" +
                    "                \"name\": \"Xomiа Readme 12\",\n" +
                    "                \"id\": \"863e1a7a-1304-42ae-943b-179184c077e3112\",\n" +
                    "                \"parentId\": \"863e1a7a-1304-42ae-943b-179184c077e311\",\n" +
                    "                \"price\": 59999\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"updateDate\": \"2022-02-02T18:01:00.000Z\"\n" +
                    "    " +
                    "}",
            // Родителем товара является товар из базы данных
            "{\n" +
                    "        \"items\": [\n" +
                    "            {\n" +
                    "                \"type\": \"OFFER\",\n" +
                    "                \"name\": \"Xomiа Readme 12\",\n" +
                    "                \"id\": \"73bc3b36-02d1-4245-ab35-3106c9ee1c6511\",\n" +
                    "                \"parentId\": \"73bc3b36-02d1-4245-ab35-3106c9ee1c65\",\n" +
                    "                \"price\": 6999\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"updateDate\": \"2022-02-03T15:00:00.000Z\"\n" +
                    "    }",
            //Изменение категории на товар
            "{\n" +
                    "        \"items\": [\n" +
                    "            {\n" +
                    "                \"type\": \"OFFER\",\n" +
                    "                \"name\": \"Товары\",\n" +
                    "                \"id\": \"069cb8d7-bbdd-47d3-ad8f-82ef4c269df1\",\n" +
                    "                \"parentId\": null\n," +
                    "                \"price\": 12345\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"updateDate\": \"2022-02-01T18:01:00.000Z\"\n" +
                    "    " +
                    "}",
            //Изменение товара на категорию
            "{\n" +
                    "        \"items\": [\n" +
                    "            {\n" +
                    "                \"type\": \"CATEGORY\",\n" +
                    "                \"name\": \"Goldstar 65\\\" LED UHD LOL Very Smart\",\n" +
                    "                \"id\": \"73bc3b36-02d1-4245-ab35-3106c9ee1c65\",\n" +
                    "                \"parentId\": null\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"updateDate\": \"2022-02-03T18:01:00.000Z\"\n" +
                    "    " +
                    "}",
            // Цена равна null
            "{\n" +
                    "        \"items\": [\n" +
                    "            {\n" +
                    "                \"type\": \"OFFER\",\n" +
                    "                \"name\": \"Xomiа Readme 13\",\n" +
                    "                \"id\": \"73bc3b36-02d1-4245-ab35-3106c9ee1c9999\",\n" +
                    "                \"parentId\": \"d515e43f-f3f6-4471-bb77-6b455017a2d2\",\n" +
                    "                \"price\": null\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"updateDate\": \"2022-02-03T18:01:00.000Z\"\n" +
                    "    }",
            // Цена отрицательное число
            "{\n" +
                    "        \"items\": [\n" +
                    "            {\n" +
                    "                \"type\": \"OFFER\",\n" +
                    "                \"name\": \"Xomiа Readme 13\",\n" +
                    "                \"id\": \"73bc3b36-02d1-4245-ab35-3106c9ee1c9999\",\n" +
                    "                \"parentId\": \"d515e43f-f3f6-4471-bb77-6b455017a2d2\",\n" +
                    "                \"price\": -5555\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"updateDate\": \"2022-02-03T18:01:00.000Z\"\n" +
                    "    }",
            //Невалидная дата
            "{\n" +
                    "        \"items\": [\n" +
                    "            {\n" +
                    "                \"type\": \"OFFER\",\n" +
                    "                \"name\": \"Xomiа Readme 13\",\n" +
                    "                \"id\": \"73bc3b36-02d1-4245-ab35-3106c9ee1c9999\",\n" +
                    "                \"parentId\": \"d515e43f-f3f6-4471-bb77-6b455017a2d2\",\n" +
                    "                \"price\": 1000\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"updateDate\": \"10.02.2022\"\n" +
                    "    }"
    };

    public final static String EXPECTED_TREE = "{\n" +
            "    \"type\": \"CATEGORY\",\n" +
            "    \"name\": \"Товары\",\n" +
            "    \"id\": \"069cb8d7-bbdd-47d3-ad8f-82ef4c269df1\",\n" +
            "    \"price\": 58599,\n" +
            "    \"parentId\": null,\n" +
            "    \"date\": \"2022-02-03T15:00:00.000Z\",\n" +
            "    \"children\": [\n" +
            "        {\n" +
            "            \"type\": \"CATEGORY\",\n" +
            "            \"name\": \"Смартфоны\",\n" +
            "            \"id\": \"d515e43f-f3f6-4471-bb77-6b455017a2d2\",\n" +
            "            \"parentId\": \"069cb8d7-bbdd-47d3-ad8f-82ef4c269df1\",\n" +
            "            \"price\": 69999,\n" +
            "            \"date\": \"2022-02-02T12:00:00.000Z\",\n" +
            "            \"children\": [\n" +
            "                {\n" +
            "                    \"type\": \"OFFER\",\n" +
            "                    \"name\": \"jPhone 13\",\n" +
            "                    \"id\": \"863e1a7a-1304-42ae-943b-179184c077e3\",\n" +
            "                    \"parentId\": \"d515e43f-f3f6-4471-bb77-6b455017a2d2\",\n" +
            "                    \"price\": 79999,\n" +
            "                    \"date\": \"2022-02-02T12:00:00.000Z\",\n" +
            "                    \"children\": null\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"OFFER\",\n" +
            "                    \"name\": \"Xomiа Readme 10\",\n" +
            "                    \"id\": \"b1d8fd7d-2ae3-47d5-b2f9-0f094af800d4\",\n" +
            "                    \"parentId\": \"d515e43f-f3f6-4471-bb77-6b455017a2d2\",\n" +
            "                    \"price\": 59999,\n" +
            "                    \"date\": \"2022-02-02T12:00:00.000Z\",\n" +
            "                    \"children\": null\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"type\": \"CATEGORY\",\n" +
            "            \"name\": \"Телевизоры\",\n" +
            "            \"id\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
            "            \"parentId\": \"069cb8d7-bbdd-47d3-ad8f-82ef4c269df1\",\n" +
            "            \"price\": 50999,\n" +
            "            \"date\": \"2022-02-03T15:00:00.000Z\",\n" +
            "            \"children\": [\n" +
            "                {\n" +
            "                    \"type\": \"OFFER\",\n" +
            "                    \"name\": \"Samson 70\\\" LED UHD Smart\",\n" +
            "                    \"id\": \"98883e8f-0507-482f-bce2-2fb306cf6483\",\n" +
            "                    \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
            "                    \"price\": 32999,\n" +
            "                    \"date\": \"2022-02-03T12:00:00.000Z\",\n" +
            "                    \"children\": null\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"OFFER\",\n" +
            "                    \"name\": \"Phyllis 50\\\" LED UHD Smarter\",\n" +
            "                    \"id\": \"74b81fda-9cdc-4b63-8927-c978afed5cf4\",\n" +
            "                    \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
            "                    \"price\": 49999,\n" +
            "                    \"date\": \"2022-02-03T12:00:00.000Z\",\n" +
            "                    \"children\": null\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"OFFER\",\n" +
            "                    \"name\": \"Goldstar 65\\\" LED UHD LOL Very Smart\",\n" +
            "                    \"id\": \"73bc3b36-02d1-4245-ab35-3106c9ee1c65\",\n" +
            "                    \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
            "                    \"price\": 69999,\n" +
            "                    \"date\": \"2022-02-03T15:00:00.000Z\",\n" +
            "                    \"children\": null\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public final static String EXPECTED_TREE_AFTER_DELETE = "{\n" +
            "    \"type\": \"CATEGORY\",\n" +
            "    \"name\": \"Товары\",\n" +
            "    \"id\": \"069cb8d7-bbdd-47d3-ad8f-82ef4c269df1\",\n" +
            "    \"price\": 50999,\n" +
            "    \"parentId\": null,\n" +
            "    \"date\": \"2022-02-03T15:00:00.000Z\",\n" +
            "    \"children\": [\n" +
            "        {\n" +
            "            \"type\": \"CATEGORY\",\n" +
            "            \"name\": \"Телевизоры\",\n" +
            "            \"id\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
            "            \"parentId\": \"069cb8d7-bbdd-47d3-ad8f-82ef4c269df1\",\n" +
            "            \"price\": 50999,\n" +
            "            \"date\": \"2022-02-03T15:00:00.000Z\",\n" +
            "            \"children\": [\n" +
            "                {\n" +
            "                    \"type\": \"OFFER\",\n" +
            "                    \"name\": \"Samson 70\\\" LED UHD Smart\",\n" +
            "                    \"id\": \"98883e8f-0507-482f-bce2-2fb306cf6483\",\n" +
            "                    \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
            "                    \"price\": 32999,\n" +
            "                    \"date\": \"2022-02-03T12:00:00.000Z\",\n" +
            "                    \"children\": null\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"OFFER\",\n" +
            "                    \"name\": \"Phyllis 50\\\" LED UHD Smarter\",\n" +
            "                    \"id\": \"74b81fda-9cdc-4b63-8927-c978afed5cf4\",\n" +
            "                    \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
            "                    \"price\": 49999,\n" +
            "                    \"date\": \"2022-02-03T12:00:00.000Z\",\n" +
            "                    \"children\": null\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"OFFER\",\n" +
            "                    \"name\": \"Goldstar 65\\\" LED UHD LOL Very Smart\",\n" +
            "                    \"id\": \"73bc3b36-02d1-4245-ab35-3106c9ee1c65\",\n" +
            "                    \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
            "                    \"price\": 69999,\n" +
            "                    \"date\": \"2022-02-03T15:00:00.000Z\",\n" +
            "                    \"children\": null\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    public final static String EXPECTED_TREE_SALES = "[\n" +
            "                {\n" +
            "                    \"type\": \"OFFER\",\n" +
            "                    \"name\": \"Samson 70\\\" LED UHD Smart\",\n" +
            "                    \"id\": \"98883e8f-0507-482f-bce2-2fb306cf6483\",\n" +
            "                    \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
            "                    \"price\": 32999,\n" +
            "                    \"date\": \"2022-02-03T12:00:00.000Z\",\n" +
            "                    \"children\": null\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"OFFER\",\n" +
            "                    \"name\": \"Phyllis 50\\\" LED UHD Smarter\",\n" +
            "                    \"id\": \"74b81fda-9cdc-4b63-8927-c978afed5cf4\",\n" +
            "                    \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
            "                    \"price\": 49999,\n" +
            "                    \"date\": \"2022-02-03T12:00:00.000Z\",\n" +
            "                    \"children\": null\n" +
            "                },\n" +
            "                {\n" +
            "                    \"type\": \"OFFER\",\n" +
            "                    \"name\": \"Goldstar 65\\\" LED UHD LOL Very Smart\",\n" +
            "                    \"id\": \"73bc3b36-02d1-4245-ab35-3106c9ee1c65\",\n" +
            "                    \"parentId\": \"1cc0129a-2bfe-474c-9ee6-d435bf5fc8f2\",\n" +
            "                    \"price\": 69999,\n" +
            "                    \"date\": \"2022-02-03T15:00:00.000Z\",\n" +
            "                    \"children\": null\n" +
            "                }\n" +
            "            ]\n";
}
