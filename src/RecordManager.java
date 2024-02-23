
public class RecordManager {

	EmployeeDetails employeeDetails;
	public RecordManager(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	
	// find byte start in file for first active record
		void firstRecord() {
			// if any active record in file look for first record
			if (employeeDetails.isSomeoneToDisplay()) {
				// open file for reading
				employeeDetails.application.openReadFile(employeeDetails.file.getAbsolutePath());
				// get byte start in file for first record
				employeeDetails.currentByteStart = employeeDetails.application.getFirst();
				// assign current Employee to first record in file
				employeeDetails.currentEmployee = employeeDetails.application.readRecords(employeeDetails.currentByteStart);
				employeeDetails.application.closeReadFile();// close file for reading
				// if first record is inactive look for next record
				if (employeeDetails.currentEmployee.getEmployeeId() == 0)
					nextRecord();// look for next record
			} // end if
		}// end firstRecord

		// find byte start in file for previous active record
		void previousRecord() {
			// if any active record in file look for first record
			if (employeeDetails.isSomeoneToDisplay()) {
				// open file for reading
				employeeDetails.application.openReadFile(employeeDetails.file.getAbsolutePath());
				// get byte start in file for previous record
				employeeDetails.currentByteStart = employeeDetails.application.getPrevious(employeeDetails.currentByteStart);
				// assign current Employee to previous record in file
				employeeDetails.currentEmployee = employeeDetails.application.readRecords(employeeDetails.currentByteStart);
				// loop to previous record until Employee is active - ID is not 0
				while (employeeDetails.currentEmployee.getEmployeeId() == 0) {
					// get byte start in file for previous record
					employeeDetails.currentByteStart = employeeDetails.application.getPrevious(employeeDetails.currentByteStart);
					// assign current Employee to previous record in file
					employeeDetails.currentEmployee = employeeDetails.application.readRecords(employeeDetails.currentByteStart);
				} // end while
				employeeDetails.application.closeReadFile();// close file for reading
			}
		}// end previousRecord

		// find byte start in file for next active record
		void nextRecord() {
			// if any active record in file look for first record
			if (employeeDetails.isSomeoneToDisplay()) {
				// open file for reading
				employeeDetails.application.openReadFile(employeeDetails.file.getAbsolutePath());
				// get byte start in file for next record
				employeeDetails.currentByteStart = employeeDetails.application.getNext(employeeDetails.currentByteStart);
				// assign current Employee to record in file
				employeeDetails.currentEmployee = employeeDetails.application.readRecords(employeeDetails.currentByteStart);
				// loop to previous next until Employee is active - ID is not 0
				while (employeeDetails.currentEmployee.getEmployeeId() == 0) {
					// get byte start in file for next record
					employeeDetails.currentByteStart = employeeDetails.application.getNext(employeeDetails.currentByteStart);
					// assign current Employee to next record in file
					employeeDetails.currentEmployee = employeeDetails.application.readRecords(employeeDetails.currentByteStart);
				} // end while
				employeeDetails.application.closeReadFile();// close file for reading
			} // end if
		}// end nextRecord

		// find byte start in file for last active record
		void lastRecord() {
			// if any active record in file look for first record
			if (employeeDetails.isSomeoneToDisplay()) {
				// open file for reading
				employeeDetails.application.openReadFile(employeeDetails.file.getAbsolutePath());
				// get byte start in file for last record
				employeeDetails.currentByteStart = employeeDetails.application.getLast();
				// assign current Employee to first record in file
				employeeDetails.currentEmployee = employeeDetails.application.readRecords(employeeDetails.currentByteStart);
				employeeDetails.application.closeReadFile();// close file for reading
				// if last record is inactive look for previous record
				if (employeeDetails.currentEmployee.getEmployeeId() == 0)
					previousRecord();// look for previous record
			} // end if
		}// end lastRecord
}
