import javax.swing.JDialog;
import java.util.Vector;

// Abstract factory interface for dialog creation
public interface DialogFactory {
    JDialog createEmployeeSummaryDialog(EmployeeDetails parent, Vector<Object> allEmployees);
    JDialog createSearchByIdDialog(EmployeeDetails parent);
    JDialog createSearchBySurnameDialog(EmployeeDetails parent);
    JDialog createAddRecordDialog(EmployeeDetails parent, ClearFields clearFields, RecordManager recordManager);
}

// Concrete factory implementing the DialogFactory interface
class ConcreteDialogFactory implements DialogFactory {
    @Override
    public JDialog createEmployeeSummaryDialog(EmployeeDetails parent, Vector<Object> allEmployees) {
        return new EmployeeSummaryDialog(parent, allEmployees);
    }

    @Override
    public JDialog createSearchByIdDialog(EmployeeDetails parent) {
        return new SearchByIdDialog(parent);
    }

    @Override
    public JDialog createSearchBySurnameDialog(EmployeeDetails parent) {
        return new SearchBySurnameDialog(parent);
    }

    @Override
    public JDialog createAddRecordDialog(EmployeeDetails parent, ClearFields clearFields, RecordManager recordManager) {
        return new AddRecordDialog(parent, clearFields, recordManager);
    }
}
