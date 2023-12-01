package org.example.entities;

    public abstract class BaseEntity {
        private int id;
        private String createDate;
        private String updateDate;
        private State State;

        public BaseEntity() {
        }

        public BaseEntity(int id, String createDate, String updateDate, org.example.entities.State state) {
            this.id = id;
            this.createDate = createDate;
            this.updateDate = updateDate;
            State = state;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public org.example.entities.State getState() {
            return State;
        }

        public void setState(org.example.entities.State state) {
            State = state;
        }

        @Override
        public String toString() {
            return "BaseEntity{" +
                    "id=" + id +
                    ", createDate='" + createDate + '\'' +
                    ", updateDate='" + updateDate + '\'' +
                    ", State=" + State +
                    '}';
        }
    }
