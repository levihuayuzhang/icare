#!/bin/sh

# use for start up graphic interface of Jmeter
#jmeter -t ./testing/Jmeter/test-plan.jmx

# use for no graphic testing and generate report
# -n for no graphic
# -t for jmx project file
# -l log file
# -e for export report
# -o for report output location
jmeter -n -t ./testing/Jmeter/test-plan.jmx -l ./testing/Jmeter/result/result.txt -e -o ./testing/Jmeter/webreport