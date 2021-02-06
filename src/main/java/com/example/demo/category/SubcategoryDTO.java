package com.example.demo.category;

 class SubcategoryDTO {

        private Long id;
        private String name;
        private String description;

         SubcategoryDTO(String name, String description) {
            this.name = name;
            this.description = description;
        }

        SubcategoryDTO() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "CoursesSubcategories{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }