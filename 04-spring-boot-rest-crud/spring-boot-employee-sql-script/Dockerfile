# Use MySQL base image
FROM mysql:8.4

# Copy the SQL initialization script to a location in the container
COPY employee-directory.sql /docker-entrypoint-initdb.d/

# Set environment variables (optional)
ENV MYSQL_DATABASE=employee_directory
ENV MYSQL_USER=springstudent
ENV MYSQL_PASSWORD=springstudent
ENV MYSQL_ROOT_PASSWORD=root

