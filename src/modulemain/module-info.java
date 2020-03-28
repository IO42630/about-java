/**
 * module-info must be in the root directory of the module
 * regular class and package names may not contain '-'
 */
module modulemain {


    requires moduletransit; // works just fine, this is just IntelliJ complaining.
}


// this doesn't seem to refer to a certain path
// at least it is not checked
// TODO verify how this works.