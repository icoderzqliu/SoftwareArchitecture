package pojo;

import java.util.List;

public class Res_Categories {


    private List<CategoriesBean> categories;

    public List<CategoriesBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesBean> categories) {
        this.categories = categories;
    }

    public static class CategoriesBean {
        /**
         * cat_id : 1
         * name : 父级分类名称
         * sub_categories : [{"cat_id":"2","name":"java se"},{"cat_id":"3","name":"java ee"}]
         */

        private String catId;
        private String name;
        private List<SubcategoriesBean> subcategories;

        public String getCatId() {
            return catId;
        }

        public void setCatId(String catId) {
            this.catId = catId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SubcategoriesBean> getSubcategories() {
            return subcategories;
        }

        public void setSubcategories(List<SubcategoriesBean> subcategories) {
            this.subcategories = subcategories;
        }

        public static class SubcategoriesBean {
            /**
             * cat_id : 2
             * name : java se
             */

            private String catId;
            private String name;

            public String getCatId() {
                return catId;
            }

            public void setCatId(String catId) {
                this.catId = catId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
