package com.managercours.entities;

public class Courses {
	  private long id;
	    private String courseName;
	    
		public Courses(long id, String courseName) {
			super();
			this.id = id;
			this.courseName = courseName;
		}

		/**
		 * @return the id
		 */
		public long getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(long id) {
			this.id = id;
		}

		/**
		 * @return the courseName
		 */
		public String getCourseName() {
			return courseName;
		}

		/**
		 * @param courseName the courseName to set
		 */
		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}

		@Override
		public String toString() {
			return "Courses [id=" + id + ", courseName=" + courseName + "]";
		}
		

}
