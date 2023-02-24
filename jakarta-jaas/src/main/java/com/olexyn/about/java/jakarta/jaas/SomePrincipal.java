package com.olexyn.about.java.jakarta.jaas;

import java.security.Principal;

/**
 * This class implements the {@code Principal} interface
 * and represents a Sample user.
 *
 * Principals such as this {@code SamplePrincipal}
 * may be associated with a particular {@code Subject}
 * to augment that {@code Subject} with an additional
 * identity.  Refer to the {@code Subject} class for more information
 * on how to achieve this.  Authorization decisions can then be based upon
 * the Principals associated with a {@code Subject}.
 *
 * @see java.security.Principal
 * @see javax.security.auth.Subject
 */
public class SomePrincipal implements Principal, java.io.Serializable {

	/**
	 * @serial
	 */
	private String name;

	/**
	 * Create a SamplePrincipal with a Sample username.
	 *
	 * @param name the Sample username for this user.
	 * @throws NullPointerException if the <code>name</code>
	 *                              is <code>null</code>.
	 */
	public SomePrincipal(String name) {
		if (name == null) {
			throw new NullPointerException("illegal null input");
		}

		this.name = name;
	}

	/**
	 * Return the Sample username for this <code>SamplePrincipal</code>.
	 *
	 * @return the Sample username for this <code>SamplePrincipal</code>
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return a string representation of this <code>SamplePrincipal</code>.
	 *
	 * @return a string representation of this <code>SamplePrincipal</code>.
	 */
	public String toString() {
		return ("SamplePrincipal:  " + name);
	}

	/**
	 * Compares the specified Object with this <code>SamplePrincipal</code>
	 * for equality.  Returns true if the given object is also a
	 * <code>SamplePrincipal</code> and the two SamplePrincipals
	 * have the same username.
	 *
	 * @param o Object to be compared for equality with this
	 * <code>SamplePrincipal</code>.
	 * @return true if the specified Object is equal equal to this
	 * <code>SamplePrincipal</code>.
	 */
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}

		if (this == o) {
			return true;
		}

		if (!(o instanceof SomePrincipal)) {
			return false;
		}
		SomePrincipal that = (SomePrincipal) o;

		if (this.getName().equals(that.getName())) {
			return true;
		}
		return false;
	}

	/**
	 * Return a hash code for this <code>SamplePrincipal</code>.
	 *
	 * @return a hash code for this <code>SamplePrincipal</code>.
	 */
	public int hashCode() {
		return name.hashCode();
	}
}
