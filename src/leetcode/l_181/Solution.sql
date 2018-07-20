select E.Name Employee
from Employee E, Employee M
where E.ManagerId = M.Id and E.Salary > M.salary;
