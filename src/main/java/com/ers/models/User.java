package com.ers.models;




public class User extends AbstractUser {

	    public User() {
	        super();
	    }

	   

		public int getRoleId() {
			return roleId;
		}


		public void setRoleId(int roleId) {
			this.roleId = roleId;
		}



		private String f_name;
	    private String l_name;
	    private String email;
	    private String address;
	    private int roleId;
	    private int userId;
	    

		public User(int id, String username, String password,  Role role) {
			super();
		
		}
		

		public User(String username, String password,   int roleId) {
			super();
		
		}

		public User(String f_name, String l_name, String email,  String address) {
			super();
			this.f_name = f_name;
			this.l_name = l_name;
			this.email = email;
			this.address = address;
		}
	    



		public User(String f_name, String l_name, String email, String address, int roleId) {
			super();
			this.f_name = f_name;
			this.l_name = l_name;
			this.email = email;
			this.address = address;
			this.roleId = roleId;
		}



		public User(String f_name, String l_name, String email, String address, int roleId, int userId) {
			super();
			this.f_name = f_name;
			this.l_name = l_name;
			this.email = email;
			this.address = address;
			this.roleId = roleId;
			this.userId = userId;
		}



		public String getF_name() {
			return f_name;
		}

		public void setF_name(String f_name) {
			this.f_name = f_name;
		}

		public String getL_name() {
			return l_name;
		}

		public void setL_name(String l_name) {
			this.l_name = l_name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}


		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((l_name == null) ? 0 : l_name.hashCode());
			result = prime * result + ((address == null) ? 0 : address.hashCode());
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((f_name == null) ? 0 : f_name.hashCode());
			
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if (l_name == null) {
				if (other.l_name != null)
					return false;
			} else if (!l_name.equals(other.l_name))
				return false;
			if (address == null) {
				if (other.address != null)
					return false;
			} else if (!address.equals(other.address))
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (f_name == null) {
				if (other.f_name != null)
					return false;
			} else if (!f_name.equals(other.f_name))
				return false;
			
			return true;
		}

		@Override
		public String toString() {
			return "User [f_name=" + f_name + ", l_name=" + l_name + ", email=" + email + ", address=" + address
					+ "]";
		}
	    
	    
	}


