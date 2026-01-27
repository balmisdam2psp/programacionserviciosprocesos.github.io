ProcessBuilder processBuilder = new ProcessBuilder("/bin/sh", "-c", "echo hello");

processBuilder.inheritIO();
Process process = processBuilder.start();

int exitCode = process.waitFor();