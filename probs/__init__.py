import inspect
import pkgutil
import unittest


def load_tests(loader, suite, pattern):
    print("__path__={}".format(__path__))
    for imp, modname, _ in pkgutil.walk_packages(__path__):
        mod = imp.find_module(modname).load_module(modname)
        for memname, memobj in inspect.getmembers(mod):
            if inspect.isclass(memobj):
                if issubclass(memobj, unittest.TestCase):
                    print("Found TestCase: {}".format(memobj))
                    for test in loader.loadTestsFromTestCase(memobj):
                        print("  Found Test: {}".format(test))
                        suite.addTest(test)

    print("=" * 70)
    return suite
