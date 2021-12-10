# Most-Active-Cookie

Command line program that processes cookie log file and returns the most active cookie for specified day. If multiple cookies meet that criteria, all cookies are returned on separate lines.

cookie log file format:

cookie,timestamp

AtY0laUfhglK3lC7,2018-12-09T14:19:00+00:00

SAZuXPGUrfbcn5UA,2018-12-09T10:13:00+00:00

5UAVanZf6UtGyKVS,2018-12-09T07:25:00+00:00

AtY0laUfhglK3lC7,2018-12-09T06:19:00+00:00

SAZuXPGUrfbcn5UA,2018-12-08T22:03:00+00:00

4sMM2LxV07bPJzwf,2018-12-08T21:30:00+00:00

fbcn5UAVanZf6UtG,2018-12-08T09:30:00+00:00

4sMM2LxV07bPJzwf,2018-12-07T23:30:00+00:00

Command:

$ ./most_active_cookie cookie_log.csv -d 2018-12-09

Output:

AtY0laUfhglK3lC7

Command:

$ ./most_active_cookie cookie_log.csv -d 2018-12-08

Output:

SAZuXPGUrfbcn5UA
4sMM2LxV07bPJzwf
fbcn5UAVanZf6UtG
